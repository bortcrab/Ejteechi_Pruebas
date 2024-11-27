package implementaciones;

import colecciones.Queja;
import excepciones.PersistenciaException;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author karim
 */
public class QuejaDAOTest {

    private static QuejaDAO quejaDAO;
    private Date fechaPlantilla1 = new Date(1732406400000L);//Fecha con el 24 de noviembre de 2024
    private Date fechaPlantilla2 = new Date(1730419200000L);//Fecha con el 01 de noviembre de 2024
    private ObjectId auxId1 = new ObjectId("672c1501e23c507d2981e304");
    private ObjectId auxId2 = new ObjectId("777c1501e23c507d2981e304");
    private ObjectId auxId3 = new ObjectId("111c1501e23c507d2981e555");

    public QuejaDAOTest() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        quejaDAO = new QuejaDAO();
    }

    @AfterEach
    public void tearDown() {
        quejaDAO.borrarQuejas();
    }

    /**
     * Test of insertarQueja method, of class QuejaDAO.
     */
    @Test
    public void testInsertar_QuejaNormal_ReturnSuccess() throws Exception {
        //Arrange
        Queja quejaInsertar = new Queja(auxId1, "America", fechaPlantilla1, "Comentado", false, true, auxId2);
        Queja resultado;

        //Act
        quejaDAO.insertarQueja(quejaInsertar);
        resultado = quejaDAO.buscarQuejaPorId(new Queja(auxId1));

        //Assert
        assertEquals(resultado.getId().toHexString(), auxId1.toHexString());

    }

    @Test
    public void testInsertar_QuejaComoAnonimo_ReturnSuccess() throws Exception {
        //Arrange
        Queja quejaInsertar = new Queja(auxId1, "America", fechaPlantilla1, "Comentado", true, true, auxId2);
        Queja resultado;

        //Act
        quejaDAO.insertarQueja(quejaInsertar);
        resultado = quejaDAO.buscarQuejaPorId(new Queja(auxId1));

        //Assert
        assertEquals(resultado.getId().toHexString(), auxId1.toHexString());
        assertNull(resultado.getIdCliente());
    }

    /**
     * Test of obtenerQuejasPorTipo method, of class QuejaDAO.
     */
    @Test
    public void testObtener_Quejas_PorTipo_ReturnSuccess() throws Exception {
        //Arrange
        quejaDAO.insertarQueja(new Queja("Tipo1"));
        quejaDAO.insertarQueja(new Queja("Tipo1"));
        quejaDAO.insertarQueja(new Queja("Tipo2"));
        List<Queja> resultados;

        //Act
        resultados = quejaDAO.obtenerQuejasPorTipo("Tipo1");

        //Assert
        assertEquals(2, resultados.size());
        for (Queja resultado : resultados) {
            assertEquals("Tipo1", resultado.getTipo());
        }
    }

    @Test
    public void testObtener_Quejas_PorTipo_Inexistente_ReturnSuccess() throws Exception {
        //Arrange
        quejaDAO.insertarQueja(new Queja("Tipo1"));
        quejaDAO.insertarQueja(new Queja("Tipo2"));
        quejaDAO.insertarQueja(new Queja("Tipo3"));
        List<Queja> resultados;

        //Act
        resultados = quejaDAO.obtenerQuejasPorTipo("Tipo4");

        //Assert
        assertEquals(0, resultados.size());
    }

    /**
     * Test of obtenerTodasLasQuejas method, of class QuejaDAO.
     */
    @Test
    public void testObtener_TodasLasQuejas_ReturnSuccess() throws Exception {
        //Arrange
        quejaDAO.insertarQueja(new Queja("Tipo1"));
        quejaDAO.insertarQueja(new Queja("Tipo1"));
        quejaDAO.insertarQueja(new Queja("Tipo2"));
        quejaDAO.insertarQueja(new Queja("Tipo3"));
        List<Queja> resultados;

        //Act
        resultados = quejaDAO.obtenerTodasLasQuejas();

        //Assert
        assertEquals(4, resultados.size());
        for (Queja resultado : resultados) {
            assertNotNull(resultado);
        }
    }

    /**
     * Test of obtenerQuejasPorEstadoYAnonimato method, of class QuejaDAO.
     */
    @Test
    public void testObtener_QuejasPorEstadoYAnonimato_ReturnSuccess() throws Exception {
        //Arrange
        quejaDAO.insertarQueja(new Queja("Tipo1", "queja 1", true));
        quejaDAO.insertarQueja(new Queja("Tipo1", "queja 2", true));
        quejaDAO.insertarQueja(new Queja("Tipo3", "queja 3", false));
        quejaDAO.insertarQueja(new Queja("Tipo3", "queja 4", false));
        quejaDAO.insertarQueja(new Queja("Tipo2", "queja 5", true));
        List<Queja> resultado;
        List<Queja> resultado2;

        //Act
        resultado = quejaDAO.obtenerQuejasPorEstadoYAnonimato(true);
        resultado2 = quejaDAO.obtenerQuejasPorEstadoYAnonimato(false);

        //Assert
        assertEquals(3, resultado.size());
        assertEquals(2, resultado2.size());
    }

    /**
     * Test of confirmarLectura method, of class QuejaDAO.
     */
    @Test
    public void testConfirmarLectura_ReturnSuccess() throws Exception {
        //Arrange
        quejaDAO.insertarQueja(new Queja(auxId1, "Tipo1", "queja 1", false));
        Queja resultado;

        //Act
        quejaDAO.confirmarLectura(new Queja(auxId1));
        resultado = quejaDAO.buscarQuejaPorId(new Queja(auxId1));

        //Assert
        assertTrue(resultado.isLeido());
    }

    @Test
    public void testObtener_QuejaInexistente_ReturnSuccess() {
        //Arrange
        Queja quejaSinId = new Queja();
        //Act y assert
        assertThrows(PersistenciaException.class, () -> {
            quejaDAO.buscarQuejaPorId(quejaSinId);
        });

    }
}
