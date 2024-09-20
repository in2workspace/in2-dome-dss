package es.in2.dss.vault.model.provider;

public enum VaultProviderEnum {
    AZURE("azure"),
    HASHICORP("hashicorp");

    private final String providerName;

    VaultProviderEnum(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public String toString() {
        return providerName;
    }
}
