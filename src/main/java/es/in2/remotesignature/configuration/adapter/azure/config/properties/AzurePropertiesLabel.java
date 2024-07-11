package es.in2.remotesignature.configuration.adapter.azure.config.properties;


import es.in2.remotesignature.configuration.model.ConfigProviderName;
import es.in2.remotesignature.configuration.util.ConfigSourceNameAnnotation;

@ConfigSourceNameAnnotation(name = ConfigProviderName.AZURE)
public record AzurePropertiesLabel(String global) {
}
