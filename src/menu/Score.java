package menu;

public class Score {
    private String leftHandName;
    private String rightHandName;
    private int leftHandScore;
    private int rightHandScore;

    public Score(String leftHandName, String rightHandName, int leftHandScore, int rightHandScore) {
        this.leftHandName = leftHandName;
        this.rightHandName = rightHandName;
        this.leftHandScore = leftHandScore;
        this.rightHandScore = rightHandScore;
    }

    public String getLeftHandName() {
        return leftHandName;
    }

    public String getRightHandName() {
        return rightHandName;
    }

    public int getLeftHandScore() {
        return leftHandScore;
    }

    public int getRightHandScore() {
        return rightHandScore;
    }
}