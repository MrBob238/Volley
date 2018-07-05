/**
 * Created by Vladimir on 24.03.2018.
 */
public class VolleyTeam {
    private String name;

    protected static int teamCount = 0;
    private int attackSkill;
    private int defenseSkill;
    private int serveskill;
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
        this.serveskill = 10;
        this.morale = 5;
        this.totalSkill = attackSkill + blockSkill + defenseSkill + receptionSkill + serveskill;
    }

    public VolleyTeam (String name) {
        this.name = name;
        this.attackSkill = 10;
        this.blockSkill = 10;
        this.defenseSkill = 10;
        this.heightAverage = 198;
        this.receptionSkill = 10;
        this.serveskill = 10;
        this.morale = 5;
        this.totalSkill = attackSkill + blockSkill + defenseSkill + receptionSkill + serveskill;

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
        return serveskill;
    }

    public void setServeskill(int serveskill) {
        this.serveskill = serveskill;
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
}
