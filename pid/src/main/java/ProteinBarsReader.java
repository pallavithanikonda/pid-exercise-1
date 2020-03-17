import javax.xml.parsers.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ProteinBarsReader {

    public List<BarDataModel> getBarsInformation() throws ParserConfigurationException, SAXException, IOException, ParseException {
        //Initialize a list of employees
        List<BarDataModel> barInfoList = new ArrayList<BarDataModel>();
        BarDataModel barInfo = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("bars.xml"));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("bar");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                barInfo = new BarDataModel();
                barInfo.setSerialNumber(eElement.getAttribute("SN"));
                barInfo.setEnergy(Double.parseDouble(eElement.getElementsByTagName("energy").item(0).getTextContent()));
                barInfo.setFatt(Double.parseDouble(eElement.getElementsByTagName("fett").item(0).getTextContent()));
                barInfo.setKolhydrat(Double.parseDouble(eElement.getElementsByTagName("kolhydrat").item(0).getTextContent()));
                barInfo.setProtein(Double.parseDouble(eElement.getElementsByTagName("protein").item(0).getTextContent()));
                barInfo.setFiber(Double.parseDouble(eElement.getElementsByTagName("fiber").item(0).getTextContent()));
                List<ReviewDataModel> reviewsList = new ArrayList<ReviewDataModel>();


                // Iterating over review elements
                Node reviewNode = eElement.getElementsByTagName("review").item(0);
                NodeList childNodes = reviewNode.getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    Node childNode = childNodes.item(i);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE && Objects.equals("reviewer", childNode.getNodeName())) {
                        Element nodeElement = (Element) childNode;
                        ReviewDataModel reviews = new ReviewDataModel();
                        reviews.setDate(new SimpleDateFormat("yyyy-mm-dd").parse(nodeElement.getElementsByTagName("date").item(0).getTextContent()));
                        reviews.setScore(Integer.parseInt(nodeElement.getElementsByTagName("score").item(0).getTextContent()));
                        reviews.setPersonID(((Element) childNode).getAttribute("personID"));
                        reviewsList.add(reviews);
                    }
                }

                barInfo.setReviews(reviewsList);
                //Add Employee to list
                barInfoList.add(barInfo);
            }
        }
        return barInfoList;
    }

    public void getBarsName(List<BarDataModel> barsInformation) {
        for(BarDataModel barInformation: barsInformation){
            System.out.println("Bar Name: "+barInformation.getSerialNumber());
        }
    }

    public void sortByContent(List<BarDataModel> barsInformation, String content) {
        if (content.equals("protein")){
            Collections.sort(barsInformation, new ProteinComparator());
            for(BarDataModel barInformation: barsInformation){
                System.out.println("Bar Name: "+barInformation.getSerialNumber()+" Protein:"+barInformation.getProtein());
            }
        } else if(content.equals("fatt")){
            Collections.sort(barsInformation, new FattComparator());
            for(BarDataModel barInformation: barsInformation){
                System.out.println("Bar Name: "+barInformation.getSerialNumber()+" Fat:"+barInformation.getFatt());
            }
        }
    }
    public void getBarsWithFiber(List<BarDataModel>  barsInformation, double fiberValue){
        Collections.sort(barsInformation, new FiberComparator());
        for(BarDataModel barInformation: barsInformation){
            if(barInformation.getFiber() > fiberValue)
                continue;
            System.out.println("Bar Name: "+barInformation.getSerialNumber()+" Fiber:"+barInformation.getFiber());
        }
    }
    public void getBarsWithProteinByReviewer(List<BarDataModel>  barsInformation, double protein, String reviewer){
        Collections.sort(barsInformation, new ProteinComparator());
        for(BarDataModel barInformation: barsInformation){
            if(barInformation.getProtein() > protein){
                List<ReviewDataModel> reviews = barInformation.getReviews();
                for(ReviewDataModel review : reviews){
                    if(review.getPersonID().equals(reviewer))
                        System.out.println("Bar Name: "+barInformation.getSerialNumber()+" Protein:"+barInformation.getProtein()+" Reviewer:  "+reviewer);
                }

            }
        }
    }

}
