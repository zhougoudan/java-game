package test;

import org.junit.jupiter.api.Test;

import org.json.JSONArray;
import org.json.JSONObject;


import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.Gold;
import unsw.loopmania.EXP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;


import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.Character;

import unsw.loopmania.PathPosition;

import unsw.loopmania.Stake;
import unsw.loopmania.Sword;

import unsw.loopmania.Goal;

import unsw.loopmania.ModeContext;
import unsw.loopmania.Mode;
import unsw.loopmania.ModeBerserker;
import unsw.loopmania.ModeStandard;
import unsw.loopmania.ModeSurvial;



public class GoalsTest {
    @Test
    public void Gold1(){
        Gold gold = new Gold(0);
        assertEquals(gold.getCurrentGold(), 0);
        gold.setCurrentGold(1);
        assertEquals(gold.getCurrentGold(), 1);

    }
    
    @Test
    public void EXP(){
        EXP gold = new EXP(0);
        assertEquals(gold.getCurrentEXP(), 0);
        gold.setCurrentEXP(1);
        assertEquals(gold.getCurrentEXP(), 1);
    }
    @Test
    public void goal_test_complex(){
        JSONArray a1 = new JSONArray();
        JSONObject o1 = new JSONObject();
        o1.put("goal", "experience");
        o1.put("quantity", 200);

        JSONObject o2 = new JSONObject();
        o2.put("goal", "gold");
        o2.put("quantity", 200);
        a1.put(o1);
        a1.put(o2);

        JSONObject o3 = new JSONObject();
        o3.put("goal", "OR");
        o3.put("subgoals", a1);

        JSONObject o4 = new JSONObject();
        o4.put("goal", "cycles");
        o4.put("quantity", 10);

        JSONArray a2 = new JSONArray();
        a2.put(o3);
        a2.put(o4);
        JSONObject goalcondition = new JSONObject();
        goalcondition.put("goal", "AND");
        goalcondition.put("subgoals", a2);


        Goal gold = new Goal(goalcondition);
        assertEquals(gold.goalCheckHelp("gold", 5), false);
        assertEquals(gold.goalCheck(), false);

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        world.setGoalCondition(gold);

        
    }
    @Test
    public void goal_test_complex2(){
        JSONArray a1 = new JSONArray();
        JSONObject o1 = new JSONObject();
        o1.put("goal", "experience");
        o1.put("quantity", 200);

        JSONObject o2 = new JSONObject();
        o2.put("goal", "gold");
        o2.put("quantity", 200);
        a1.put(o1);
        a1.put(o2);

        JSONObject o3 = new JSONObject();
        o3.put("goal", "AND");
        o3.put("subgoals", a1);

        JSONObject o4 = new JSONObject();
        o4.put("goal", "cycles");
        o4.put("quantity", 10);

        JSONArray a2 = new JSONArray();
        a2.put(o3);
        a2.put(o4);
        JSONObject goalcondition = new JSONObject();
        goalcondition.put("goal", "OR");
        goalcondition.put("subgoals", a2);


        Goal gold = new Goal(goalcondition);
        assertEquals(gold.goalCheckHelp("experience", 5), true);
        assertEquals(gold.goalCheck(), false);

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        world.setGoalCondition(gold);

        
    }
    // { "goal": "AND", "subgoals":
    //     [ { "goal": "cycles", "quantity": 10 },
    //       { "goal": "OR", "subgoals":
    //         [ {"goal": "experience", "quantity": 200 },
    //           {"goal": "gold", "quantity": 200 }
    //         ]
    //       }
    //     ]
    // }

    @Test
    public void goal_test_middle_complex(){
        JSONObject o1 = new JSONObject();
        o1.put("goal", "experience");
        o1.put("quantity", 200);

        JSONObject o4 = new JSONObject();
        o4.put("goal", "cycles");
        o4.put("quantity", 10);

        JSONArray a2 = new JSONArray();
        a2.put(o1);
        a2.put(o4);
        JSONObject goalcondition = new JSONObject();
        goalcondition.put("goal", "AND");
        goalcondition.put("subgoals", a2);


        Goal gold = new Goal(goalcondition);
        assertEquals(gold.goalCheckHelp("gold", 5), false);
        assertEquals(gold.goalCheck(), false);

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        world.setGoalCondition(gold);

        
    }
    @Test
    public void goal_test_middle_complex2(){
        JSONObject o1 = new JSONObject();
        o1.put("goal", "experience");
        o1.put("quantity", 200);

        JSONObject o4 = new JSONObject();
        o4.put("goal", "cycles");
        o4.put("quantity", 10);

        JSONArray a2 = new JSONArray();
        a2.put(o1);
        a2.put(o4);
        JSONObject goalcondition = new JSONObject();
        goalcondition.put("goal", "OR");
        goalcondition.put("subgoals", a2);


        Goal gold = new Goal(goalcondition);
        assertEquals(gold.goalCheckHelp("cycles", 5), true);
        //assertEquals(gold.goalCheck(100, 1, 1), false);

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        world.setGoalCondition(gold);

        
    }
    @Test
    // { "goal": "AND", "subgoals":
    //   [ { "goal": "cycles", "quantity": 10 },
    //     {"goal": "experience", "quantity": 200 }
    //   ]
    // }
    public void goal_test_middle_EASY(){
        JSONObject goalcondition = new JSONObject();
        goalcondition.put("goal", "experience");
        goalcondition.put("quantity", 200);

        Goal gold = new Goal(goalcondition);
        assertEquals(gold.goalCheckHelp("gold", 5), false);
        assertEquals(gold.goalCheck(), false);

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        world.setGoalCondition(gold);

        Character character = new Character(pathPosition);
        
    }
    @Test
    // { "goal": "AND", "subgoals":
    //   [ { "goal": "cycles", "quantity": 10 },
    //     {"goal": "experience", "quantity": 200 }
    //   ]
    // }
    public void goal_test_middle_EASY2(){
        JSONArray a1 = new JSONArray();
        JSONObject goalcondition = new JSONObject();
        goalcondition.put("goal", "go");
        goalcondition.put("quantity", 200);

        Goal gold = new Goal(goalcondition);
        assertEquals(gold.goalCheckHelp("gold", 5), false);
        assertEquals(gold.goalCheck(), false);

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        world.setGoalCondition(gold);

        
    }
    @Test
    public void mode (){

        ModeContext modeContext = new ModeContext(new ModeBerserker());
        Mode mode_req = modeContext.executeMode("berserker");
        modeContext = new ModeContext(new ModeStandard());
        mode_req = modeContext.executeMode("Standard");
        modeContext = new ModeContext(new ModeSurvial());
        mode_req = modeContext.executeMode("survival");


    }
    @Test
    public void goalcheck (){
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<Integer, Integer>(0,0));
        PathPosition pathPosition = new PathPosition(0, orderedPath);
        LoopManiaWorld world = new LoopManiaWorld(32, 21, orderedPath);
        Character character = new Character(pathPosition);
        Stake stake = new Stake(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 4, 0, 10);
        // check character without equip stake
        assertEquals(character.getAggressivity(), 4);
        assertEquals(character.getDefense(), 0);
        // check charcter after equip stake
        world.setCharacterEquipment(character, stake);
        assertEquals(character.getAggressivity(), 8);
        assertEquals(character.getDefense(), 0); 
        // check charcter equip a sword(new weapon)  
        Sword sword = new Sword(new SimpleIntegerProperty(0) ,new SimpleIntegerProperty(0), 6, 0, 10);
        world.setCharacterEquipment(character, sword);
        assertEquals(character.getAggressivity(), 10);
        assertEquals(character.getDefense(), 0); 
    }
}
