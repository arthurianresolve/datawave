package datawave.microservice.annotation.common;

import java.util.Map;

import datawave.annotation.protobuf.v1.Annotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnnotationMessage {
    public enum Operation {
        ADD, UPDATE, DELETE;
    }

    private Operation operation;
    private Map<String,String> parameters;
    private Annotation annotation;

    public AnnotationMessage(Annotation annotation, Operation operation, Map<String,String> parameters) {
        this.annotation = annotation;
        this.operation = operation;
        this.parameters = parameters;
    }
}
