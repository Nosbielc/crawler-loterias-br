package com.nosbielc.crawler.loterias.infrastructure.delivery.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nosbielc.crawler.loterias.core.common.exceptions.BadRequestException;
import com.nosbielc.crawler.loterias.infrastructure.shared.constants.CommonConstantsHelper;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Objects;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(toBuilder = true, builderClassName = "APIResponseBuilder", setterPrefix = "with")
public class APIResponse<T> implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;

    private String status;
    private String code;
    private String message;
    private transient T content;

    public static class APIResponseBuilder<T> {
        private String status;
        private String code;
        private String message;

        public APIResponseBuilder<T> withSuccess(final T content) {
            this.status = CommonConstantsHelper.SUCCESS;
            this.code = String.valueOf(HttpStatus.OK);
            this.message = CommonConstantsHelper.OK;
            return withContent(content);
        }

        public APIResponseBuilder<T> withCreated(final T content) {
            this.status = CommonConstantsHelper.CREATED;
            this.code = String.valueOf(HttpStatus.CREATED);
            this.message = CommonConstantsHelper.CREATED;
            return withContent(content);
        }

        private void verifyFields() {
            if (Objects.isNull(status) || Objects.isNull(code) || Objects.isNull(message)) {
                throw new BadRequestException("Response build with errors.");
            }
        }

        public APIResponse<T> build() {
            verifyFields();
            return new APIResponse(this.status, this.code, this.message, this.content);
        }
    }

}
