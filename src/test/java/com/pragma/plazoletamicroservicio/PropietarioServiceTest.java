package com.pragma.plazoletamicroservicio;


public class PropietarioServiceTest {

/*

    @Mock
    private IUsuarioPersistencePort usuarioPersistencePort;

    @Mock
    private IRolRepository rolRepository;

    @Mock
    private RolEntityMapper rolEntityMapper;

    private UsuarioUseCase usuarioUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuarioUseCase = new UsuarioUseCase(usuarioPersistencePort, rolRepository, rolEntityMapper);
    }

    @Test
    void guardarUser_ValidRol_SaveUserWithCorrectRole() {
        // Arrange
        Usuario usuario = new Usuario();
        TipoRol rol = TipoRol.PROPIETARIO;
        Long rolId = Constants.PROPIETARIO_ROL_ID;
        RolEntity rolEntity = new RolEntity();
        rolEntity.setId(rolId);
        when(rolRepository.findById(rolId)).thenReturn(Optional.of(rolEntity));

        // Act
        usuarioUseCase.guardarUser(usuario, rol);

        // Assert
        verify(usuarioPersistencePort).guardarUsuario(usuario);
        assertEquals(usuario.getIdRol().getId(), rolId);
    }

    @Test
    void guardarUser_InvalidRol_ThrowUsuarioExcepcionRolNoExiste() {
        // Arrange
        Usuario usuario = new Usuario();
        TipoRol rol = TipoRol.ADMINISTRADOR;

        // Act and Assert
        assertThrows(UsuarioExcepcionRolNoExiste.class, () -> usuarioUseCase.guardarUser(usuario, rol));
        verify(usuarioPersistencePort, never()).guardarUsuario(usuario);

        assertThrows(UsuarioExcepcionRolNoExiste.class, () -> {
            usuarioUseCase.guardarUser(usuario, rol);
        });
    }

    @Test
    void deleteUsuario_DeleteUser_CallsPersistencePortDelete() {
        // Arrange
        Usuario usuario = new Usuario();

        // Act
        usuarioUseCase.deleteUsuario(usuario);

        // Assert
        verify(usuarioPersistencePort).deleteUsuario(usuario);
    }

    @Test
    void getUsuario_ValidId_ReturnsUsuarioFromPersistencePort() {
        // Arrange
        Long id = 123L;
        Usuario expectedUsuario = new Usuario();
        when(usuarioPersistencePort.getUsuario(id)).thenReturn(expectedUsuario);

        // Act
        Usuario resultUsuario = usuarioUseCase.getUsuario(id);

        // Assert
        verify(usuarioPersistencePort).getUsuario(id);
        assertEquals(resultUsuario, expectedUsuario);
    }

    @Test
    void validarPropietario_ValidId_ReturnsTrueIfUsuarioIsPropietario() {
        // Arrange
        Long id = 123L;
        Usuario propietario = new Usuario();
        Rol rolPropietario = new Rol();
        rolPropietario.setId(Constants.PROPIETARIO_ROL_ID);
        propietario.setIdRol(rolPropietario);
        when(usuarioPersistencePort.getUsuario(id)).thenReturn(propietario);

        // Act
        Boolean result = usuarioUseCase.validarPropietario(id);

        // Assert
        verify(usuarioPersistencePort).getUsuario(id);
        assertTrue(result);
    }
 */

}
