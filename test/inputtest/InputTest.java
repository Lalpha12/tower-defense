package inputtest;



import java.io.*;
import java.util.*;
import org.junit.*;
import TowerDefence.listchooser.*;
import TowerDefence.listchooser.util.*;
import TowerDefence.tower.*;
import static org.junit.Assert.*;

public class InputTest {

    private static InputStream systemIn;
    private static PrintStream systemOut;
    private InteractiveListChooser <Tour> interactiveChooser;
    private RandomListChooser <Tour> randomChooser;
    private List<Tour>listes;

    @BeforeClass
    public static void changeSystemOut(){
        System.out.println("tests begin");
        systemIn=System.in;
        systemOut=System.out;
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }

    @AfterClass
    public static void restoreSystemInOut(){
        System.setIn(systemIn);
        System.setOut(systemOut);
        System.out.println("test end");
    }
    @Before
    public  void init(){
        this.interactiveChooser=new InteractiveListChooser<>();
        this.randomChooser=new RandomListChooser<>();
        this.listes=new ArrayList<>();
        listes.add(new SingeFlechettes());
        listes.add(new TourBombe());
        listes.add(new Gorille());
        listes.add(new SingeTireurElite());
        listes.add(new TourelleAiguille());
        listes.add(new TourRballoon(3));
        listes.add(new TourfrozenBalloon(9));

    }

    public void simulateInput(String input){
        InputStream in =new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


    }
    @Test
    public void testInteractivechoixvalide(){
        this.simulateInput("4");
        Tour   result=this.interactiveChooser.choose("choisissez une tour",this.listes);
        assertTrue(result instanceof  SingeTireurElite );

    }
    @Test
    public void  testInteractive(){
      for (int i = 1; i < this.listes.size(); i++) {
        this.simulateInput(String.valueOf(i));
        Tour resul=this.interactiveChooser.choose("le  choix est large", listes);
        assertEquals(this.listes.get(i-1),resul);
      }



    }



    //----------------k
    //test de alea ou random comm on dit
    //---------------k

    @Test 
    public void testRandomchooser(){
        Tour resul=this.randomChooser.choose("choix aléa ", this.listes);
        assertTrue(this.listes.contains(resul));
    }
    @Test
    public void testRandomlistevide(){
        List<Tour>listevide=new ArrayList<>();
        Tour resul=this.randomChooser.choose("pas de choix", listevide);
        assertNull(resul);
    }

    @Test
    public void testRandomuneseulechoix(){
    List<Tour> listune=new ArrayList<>();
    listune.add(new SingeFlechettes());
    listune.add(new SingeFlechettes());
    Tour result=this.randomChooser.choose("choix", listune);
    assertTrue(result instanceof SingeFlechettes);
    }
}
