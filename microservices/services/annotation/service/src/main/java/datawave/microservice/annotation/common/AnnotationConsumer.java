package datawave.microservice.annotation.common;

import java.util.function.Consumer;

import datawave.annotation.protobuf.v1.Annotation;
import datawave.microservice.annotation.writers.AnnotationWriter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnnotationConsumer implements Consumer<AnnotationMessage> {

    private final AnnotationWriter annotationWriter;

    public AnnotationConsumer(AnnotationWriter annotationWriter) {
        this.annotationWriter = annotationWriter;
    }

    @Override
    public void accept(AnnotationMessage annotationMessage) {
        try {
            Annotation a = annotationMessage.getAnnotation();
            annotationWriter.write(a);
        } catch (Exception e) {
            log.error("Error processing annotation message: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
