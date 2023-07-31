package com.nosbielc.crawler.loterias;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.properties.HasName;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.Architectures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@AnalyzeClasses(packages = "com.nosbielc.crawler.loterias")
public class ProjectRuleTest {

    @ArchTest
    public void defineProjectArchitectureRule(JavaClasses importedAllClasses) {

        Architectures.layeredArchitecture().consideringAllDependencies()

                .layer("Delivery").definedBy(HasName.Predicates.nameEndingWith("ControllerImpl"))
                .layer("Ports").definedBy(HasName.Predicates.nameEndingWith("ServiceImpl"))
                .layer("UseCase").definedBy(HasName.Predicates.nameEndingWith("UseCaseImpl"))
                .layer("Persistence").definedBy(HasName.Predicates.nameEndingWith("Repository"))

                .whereLayer("Delivery").mayNotBeAccessedByAnyLayer()
                .whereLayer("UseCase").mayOnlyBeAccessedByLayers("Delivery")
                .whereLayer("Ports").mayOnlyBeAccessedByLayers("UseCase")
                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Ports")

                .check(importedAllClasses);
    }

    @ArchTest
    public void springComponentsShoulOnlyHaveFinalFields(JavaClasses importedAllClasses) {
        ArchRule rule = ArchRuleDefinition.classes()

                .that().areAnnotatedWith(Repository.class)
                .or().areAnnotatedWith(Service.class)
                .or().areAnnotatedWith(Component.class)
                .or().areAnnotatedWith(RestController.class)
                .should().haveOnlyFinalFields();

        rule.check(importedAllClasses);
    }

    @ArchTest
    public void springFieldDependencyInjectionShouldNotBeUsed(JavaClasses importedAllClasses) {
        ArchRule rule = ArchRuleDefinition.noFields()
                .should().beAnnotatedWith(Autowired.class);

        rule.check(importedAllClasses);
    }

}
