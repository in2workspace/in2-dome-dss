package es.in2.dss.configuration.adapter.azure.config.properties;


import es.in2.dss.configuration.model.ConfigProviderName;
import es.in2.dss.configuration.util.ConfigSourceNameAnnotation;

@ConfigSourceNameAnnotation(name = ConfigProviderName.AZURE)
public record AzurePropertiesLabel(String global) {
}
