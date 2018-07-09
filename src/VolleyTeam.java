import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Vladimir on 24.03.2018.
 */
public class VolleyTeam {
    public static Map<String, String> properties = new HashMap<>();
    private String name;

    protected static int teamCount = 0;
    private int attackSkill;
    private int defenseSkill;
    private int serveSkill;
    private int receptionSkill;
    private int blockSkill;
    private int heightAverage;
    private int morale;

    public int totalSkill;

    public VolleyTeam() {
        this.name = "Team  № " + ++teamCount;
        this.attackSkill = 10;
        this.blockSkill = 10;
        this.defenseSkill = 10;
        this.heightAverage = 198;
        this.receptionSkill = 10;
        this.serveSkill = 10;
        this.morale = 5;
        this.totalSkill = attackSkill + blockSkill + defenseSkill + receptionSkill + serveSkill;
    }

    public VolleyTeam (String name) {
        this.name = name;
        this.attackSkill = 10;
        this.blockSkill = 10;
        this.defenseSkill = 10;
        this.heightAverage = 198;
        this.receptionSkill = 10;
        this.serveSkill = 10;
        this.morale = 5;
        this.totalSkill = attackSkill + blockSkill + defenseSkill + receptionSkill + serveSkill;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAttackSkill() {
        return attackSkill;
    }

    public void setAttackSkill(int attackSkill) {
        this.attackSkill = attackSkill;
    }

    public int getDefenseSkill() {
        return defenseSkill;
    }

    public void setDefenseSkill(int defenseSkill) {
        this.defenseSkill = defenseSkill;
    }

    public int getServeskill() {
        return serveSkill;
    }

    public void setServeskill(int serveskill) {
        this.serveSkill = serveskill;
    }

    public int getReceptionSkill() {
        return receptionSkill;
    }

    public void setReceptionSkill(int receptionSkill) {
        this.receptionSkill = receptionSkill;
    }

    public int getBlockSkill() {
        return blockSkill;
    }

    public void setBlockSkill(int blockSkill) {
        this.blockSkill = blockSkill;
    }

    public int getHeightAverage() {
        return heightAverage;
    }

    public void setHeightAverage(int heightAverage) {
        this.heightAverage = heightAverage;
    }

    public int getMorale() {
        return morale;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }

    @Override
    public String toString() {
        return this.name;
    }
    public void save (String filename) {
        Properties prop = new Properties();
        this.properties.put("name", name);
        this.properties.put("attackSkill", ""+attackSkill);
        this.properties.put("defenseSkill", ""+defenseSkill);
        this.properties.put("serveSkill", ""+serveSkill);
        this.properties.put("receptionSkill", ""+receptionSkill);
        this.properties.put("blockSkill", ""+blockSkill);
        this.properties.put("morale", ""+morale);
        prop.putAll(properties);
        try {
            OutputStream outputStream = new FileOutputStream(filename);
            prop.store(outputStream,null);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void load (String filename) {
        try {
            InputStream inputStream = new FileInputStream(filename);
            Properties prop = new Properties();
            prop.load(inputStream);
            Set<String> keys = prop.stringPropertyNames();
            for (String strKey : keys) {
                this.properties.put(strKey, prop.getProperty(strKey));
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setAttackSkill(Integer.parseInt(properties.get("attackSkill")));
        this.setDefenseSkill(Integer.parseInt(properties.get("defenseSkill")));
        this.setServeskill(Integer.parseInt(properties.get("serveSkill")));
        this.setReceptionSkill(Integer.parseInt(properties.get("receptionSkill")));
        this.setBlockSkill(Integer.parseInt(properties.get("blockSkill")));
        this.setMorale(Integer.parseInt(properties.get("morale")));

    }
}
