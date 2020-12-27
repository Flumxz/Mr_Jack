import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Plateau {

    public ArrayList<CarteAlibi> pile_Alibis = new ArrayList<CarteAlibi>(9);

    public District[] districts = new District[9];

    public JetonAction[] jetonsActions = new JetonAction[4];

    public JetonDetective Holmes;
    public JetonDetective Watson;
    public JetonDetective Toby;


    public void initPlateau(){
        initDistricts();
        initDetectives();
        initPileAlibis();
        //toute la mise en place du jeu
    }

    public void initDistricts(){
        ArrayList<Integer> temp_IndicesPos = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        District IL = new District(); IL.nom = "IL"; IL.face = 1; District MS = new District(); MS.nom = "MS"; MS.face = 1; District JB = new District(); JB.nom = "JB"; JB.face = 1; District JP = new District(); JP.nom = "JP"; JP.face = 1; District JS = new District(); JS.nom = "JS"; JS.face = 1; District JL = new District(); JL.nom = "JL"; JL.face = 1; District M = new District(); M.nom = "M"; M.face = 1; District SG = new District(); SG.nom = "SG"; SG.face = 1; District WG = new District(); WG.nom = "WG"; WG.face = 1;
        District[] temp_ListeAlibis = {IL,MS,JB,JP,JS,JL,M,SG,WG};
        for (District Alibi : temp_ListeAlibis) {

            int randIndicePos = 10;
            while(!temp_IndicesPos.contains(randIndicePos)){
                randIndicePos = new Random().nextInt(9)+1;
            }
            Alibi.position = randIndicePos;
            temp_IndicesPos.remove((Integer) randIndicePos);

            Alibi.orientation = new Random().nextInt(4)+1;

            Alibi.face = 1;

        }
        for (District Alibi : temp_ListeAlibis) {
            if(Alibi.position==1) {
                Alibi.orientation=2;
            }
            if(Alibi.position==3) {
                Alibi.orientation=3;
            }
            if(Alibi.position==8) {
                Alibi.orientation=1;
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(temp_ListeAlibis[j].position==i+1){
                    this.districts[i]=temp_ListeAlibis[j];
                }
            }
        }
    }
    public void initDetectives() {
        this.Holmes = new JetonDetective("Sherlock Holmes",12);
        this.Watson = new JetonDetective("Dr Watson",4);
        this.Toby = new JetonDetective("Toby",8);
    }
    public void initPileAlibis() {
        // à faire demain wsh
    }

}
