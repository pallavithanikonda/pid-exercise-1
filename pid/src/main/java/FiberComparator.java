import java.util.Comparator;

public class FiberComparator implements Comparator<BarDataModel> {

        @Override
        public int compare(BarDataModel o1, BarDataModel o2)
        {
            if (o1.getFiber() < o2.getFiber()) return 1;
            if (o1.getFiber() > o2.getFiber()) return -1;
            return 0;
        }

}
