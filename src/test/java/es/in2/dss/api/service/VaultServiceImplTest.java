//package es.in2.dss.api.service;
//
//import es.in2.dss.z.service.VaultService;
//import es.in2.dss.z.service.impl.VaultServiceImpl;
//import es.in2.dss.model.VaultSecret;
//import es.in2.dss.vault.service.GenericVaultService;
//import es.in2.dss.vault.util.VaultFactory;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import reactor.core.publisher.Mono;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class VaultServiceImplTest {
//    @Mock
//    GenericVaultService genericVaultService;
//
//    @Mock
//    VaultFactory vaultFactory;
//
//    private VaultService vaultService;
//
//    @BeforeEach
//    public void setUp() {
//        when(vaultFactory.getVaultService()).thenReturn(genericVaultService);
//        vaultService = new VaultServiceImpl(vaultFactory);
//    }
//
//    @Test
//    void whenGetSecret_thenReturnKeyVaultSecret() {
//        VaultSecret vaultSecret = new VaultSecret("value");
//
//        when(genericVaultService.getSecret("key")).thenReturn(Mono.just(vaultSecret));
//
//        VaultSecret result = vaultService.getSecret("key");
//
//        assertEquals(vaultSecret, result);
//
//    }
//}
