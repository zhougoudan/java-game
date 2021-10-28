package unsw.loopmania;


import org.json.JSONObject;

public class Goal {
    public JSONObject conditions;
    public LoopManiaWorld loopManiaWorld;
    public int gold;
    public int exp;
    public int turns;
    public boolean bosses;

    public Goal(JSONObject condition){

        this.conditions = condition;

    }

    public void setCurrentStatus (int gold, int exp, int turns,boolean bosses){
        this.gold = gold;
        this.exp = exp;
        this.turns = turns;
        this.bosses = bosses;
    }
    public String goal_to_string(){
        String fronted = conditions.toString();
        fronted = fronted.replace("{", "\n");
        fronted = fronted.replace("}", "");
        fronted = fronted.replace("\"","");
        fronted = fronted.replace("[","(");
        fronted = fronted.replace("]",")");
        fronted = fronted.replace("quantity","");
        fronted = fronted.replace("goal:","   ");
        fronted = fronted.replace("subgoals:","");
        fronted = fronted + "\n";
        
        System.out.printf(fronted);
        return fronted;
    }

    /**
     * checking if it meets the specifct condition
     * 
     * @param  String type, int quantity, int gold, int exp, int turns
     * @return Boolean
     */
    public boolean goalCheckHelp (String type, int quantity) {
        
        switch (type) {
            case "gold" :
                return gold >= quantity;
            case "experience" :
                return exp >= quantity;
            case "cycles" :
                return turns >= quantity;
            case "bosses" :
                return bosses;
            default:
                break;
        }
        return false;
    }
    /**
     * checking if it meets the specifct condition for more conflicts version
     * 
     * @param  int gold, int exp, int turns
     * @return Boolean
     */
    public boolean goalCheck() {
        //goal_to_string();
        if (conditions == null) {
            return false;

        }

        //System.out.printf(conditions.toString(4));
        // if it's the only one level goal
        if (!conditions.has("subgoals")) {
            
            return goalCheckHelp(conditions.getString("goal"), conditions.getInt("quantity"));
        } else{
            // otherwise at least level2
            String rela = conditions.getString("goal");
            if (rela.equals("AND")) {
                AndGoal andgoal = new AndGoal(this.conditions);

                andgoal.setCurrentStatus(gold, exp, turns, bosses);
                return andgoal.subgoalcheck();

            } else {
                OrGoal orgoal = new OrGoal(this.conditions);
                orgoal.setCurrentStatus(gold, exp, turns, bosses);
                return orgoal.subgoalcheck();
            }


        }
    }
    

}