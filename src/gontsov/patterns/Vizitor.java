package gontsov.patterns;
import gontsov.trees.Node;

public class Vizitor implements EVizitor {
    int i = 0;

    public void action(Node node) {
        i++;
    }

    public int getI() {
        return i;
    }
}
