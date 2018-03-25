/**
 * Created by Vladimir on 24.03.2018.
 */
public class VolleyTeam {
    protected static int teamCount = 0;
    private int attackSkill;
    private int defenseSkill;
    private int serveskill;
    private int receptionSkill;
    private int blockSkill;
    private int heightAverage;
    private int morale;

    private String name;

    public int totalSkill;

    public VolleyTeam() {
        this.attackSkill = 10;
        this.blockSkill = 10;
        this.defenseSkill = 10;
        this.heightAverage = 198;
        this.receptionSkill = 10;
        this.serveskill = 10;
        this.morale = 5;
        this.totalSkill = attackSkill + blockSkill + defenseSkill + receptionSkill + serveskill;
        this.name = "Team  № " + ++teamCount;
    }

    public VolleyTeam (String name) {
        this.attackSkill = 10;
        this.blockSkill = 10;
        this.defenseSkill = 10;
        this.heightAverage = 198;
        this.receptionSkill = 10;
        this.serveskill = 10;
        this.morale = 5;
        this.totalSkill = attackSkill + blockSkill + defenseSkill + receptionSkill + serveskill;
        this.name = name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
