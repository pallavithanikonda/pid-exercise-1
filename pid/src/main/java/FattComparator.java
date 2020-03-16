import java.util.Comparator;

public class FattComparator implements Comparator<BarDataModel> {

        @Override
        public int compare(BarDataModel o1, BarDataModel o2)
        {
            if (o1.getFatt() < o2.getFatt()) return 1;
            if (o1.getFatt() > o2.getFatt()) return -1;
            return 0;
        }

    }
