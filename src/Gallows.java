import java.util.ArrayList;
import java.util.Arrays;

public class Gallows {
    private ArrayList<String> stages = new ArrayList<String>();
    private int currentStage = 0;

    public int getCurrentStage() {
        return currentStage;
    }

    public void setStages(String[] scenes) {
        stages.addAll(Arrays.asList(scenes));
    }

    public void drawStage() {
        System.out.println(stages.get(currentStage));
    }

    public void setCurrentStage() {
        currentStage++;
    }

    public int getStagesNumber() {
        return stages.size();
    }
}