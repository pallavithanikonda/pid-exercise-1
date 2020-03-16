import java.util.Comparator;

public class ProteinComparator implements Comparator<BarDataModel> {

        @Override
        public int compare(BarDataModel o1, BarDataModel o2)
        {
            if (o1.getProtein() < o2.getProtein()) return 1;
            if (o1.getProtein() > o2.getProtein()) return -1;
            return 0;
        }

}
