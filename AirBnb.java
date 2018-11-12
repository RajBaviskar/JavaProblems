//
//    /*
//  You are given an array of csv strings indicating search result of listings.
//  Each has a host_id, listing_id, score, and city. Initially, results are sorted by highest score.
//
//  We'd like to display these search results on a web page.
//  Write a function that returns groups of listings to be displayed on each page.
//  However, note that a given host may have several listings that show up in the results.
//  Reorder the list so that a host shows up at most once on a page if possible, but otherwise preserves the ordering.
//  Your program should return the new array and print out the results in blocks representing the pages.
//
//  Format:
//  host_id, listing_id, score, city,
//
//  String[] inputCsvArray = {
//    "1,28,300.1,San Francisco",
//    "4,5,209.1,San Francisco",
//    "20,7,208.1,San Francisco",
//    "23,8,207.1,San Francisco",
//    "16,10,206.1,Oakland",
//    "1,16,205.1,San Francisco",
//    "6,29,204.1,San Francisco",
//    "7,20,203.1,San Francisco",
//    "8,21,202.1,San Francisco",
//    "2,18,201.1,San Francisco",
//    "2,30,200.1,San Francisco",
//    "15,27,109.1,Oakland",
//    "10,13,108.1,Oakland",
//    "11,26,107.1,Oakland",
//
//    "12,9,106.1,Oakland",
//    "13,1,105.1,Oakland",
//    "22,17,104.1,Oakland",
//    "1,2,103.1,Oakland",
//    "28,24,102.1,Oakland",
//    "18,14,11.1,San Jose",
//    "6,25,10.1,Oakland",
//    "19,15,9.1,San Jose",
//    "3,19,8.1,San Jose",
//    "3,11,7.1,Oakland",
//    "27,12,6.1,Oakland",
//    "1,3,5.1,Oakland",
//    "25,4,4.1,San Jose",
//
//    "5,6,3.1,San Jose",
//    "29,22,2.1,San Jose",
//    "30,23,1.1,San Jose"
//  };
//
//  // maxListingsPerPage = 12
//  String[] sampleOutput = {
//    "1,28,300.1,San Francisco",
//    "4,5,209.1,San Francisco",
//    "20,7,208.1,San Francisco",
//    "23,8,207.1,San Francisco",
//    "16,10,206.1,Oakland",
//    "6,29,204.1,San Francisco",
//    "7,20,203.1,San Francisco",
//    "8,21,202.1,San Francisco",
//    "2,18,201.1,San Francisco",
//    "15,27,109.1,Oakland",
//    "10,13,108.1,Oakland",
//    "11,26,107.1,Oakland",
//
//    "1,16,205.1,San Francisco",
//    "2,30,200.1,San Francisco",
//    "12,9,106.1,Oakland",
//    "13,1,105.1,Oakland",
//    "22,17,104.1,Oakland",
//    "28,24,102.1,Oakland",
//    "18,14,11.1,San Jose",
//    "6,25,10.1,Oakland",
//    "19,15,9.1,San Jose",
//    "3,19,8.1,San Jose",
//    "27,12,6.1,Oakland",
//    "25,4,4.1,San Jose",
//
//
//    "1,2,103.1,Oakland",
//    "3,11,7.1,Oakland",
//    "1,3,5.1,Oakland",
//    "5,6,3.1,San Jose",
//    "29,22,2.1,San Jose",
//    "30,23,1.1,San Jose"
//  }
//
//  String[] reorderListings(String[] inputCsvArray, int maxListingsPerPage) {
//  }
//*/
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//public class AirBnb {
//        static List<String> reorderListings(String[] inputCsvArray, int maxListingsPerPage) {
//            if(inputCsvArray == null || inputCsvArray.length <= 0){
//                return new ArrayList<String>();
//            }
//
////            Set<Integer> hostSet = new HashSet<Integer>();
////            List<String> result = new ArrayList<String>();
////            List<String> putAwayList = new ArrayList<String>();
////
////            int ipLen = inputCsvArray.length;
////            for(int i = 0; i < ipLen;){
////                int counter = maxListingsPerPage;
////
////                int sideSize = putAwayList.size();
////                List<String> rm = new ArrayList<String>();
////
////                for(int j = 0; j < sideSize ;j++){
////                    String[] fields = putAwayList.get(j).split(",");
////                    int hostId = Integer.parseInt(fields[0]);
////                    if(!hostSet.contains(hostId) || ipLen - i < maxListingsPerPage){
////                        result.add(putAwayList.get(j));
////                        hostSet.add(hostId);
////                        rm.add(putAwayList.get(j));
////                        counter--;
////                        //j++;
////                        if(counter <=0){break;}
////                    }
////                }
////                System.out.println(putAwayList.toString());
////                for(int k = 0; k < rm.size() ;k++){
////                    putAwayList.remove(rm.get(k));
////                }
////                System.out.println(putAwayList.toString());
////                while(counter > 0 && i < ipLen){
////
////                    if(counter <=0){break;}
////                    String[] fields = inputCsvArray[i].split(",");
////                    int hostId = Integer.parseInt(fields[0]);
////                    if(!hostSet.contains(hostId) || ipLen - i < maxListingsPerPage){
////                        result.add(inputCsvArray[i]);
////                        hostSet.add(hostId);
////                        counter--;
////                        i++;
////                    }else{
////                        System.out.println(i);
////                        putAwayList.add(inputCsvArray[i]);
////                        i++;
////                    }
////                }
////                hostSet.clear();
////            }
////
////            return result;
//        }
//
//        public static void main(String[] args) {
//            String[] inputCsvArray = {
//                    "1,28,300.1,San Francisco",
//                    "4,5,209.1,San Francisco",
//                    "20,7,208.1,San Francisco",
//                    "23,8,207.1,San Francisco",
//                    "16,10,206.1,Oakland",
//                    "1,16,205.1,San Francisco",
//                    "6,29,204.1,San Francisco",
//                    "7,20,203.1,San Francisco",
//                    "8,21,202.1,San Francisco",
//                    "2,18,201.1,San Francisco",
//                    "2,30,200.1,San Francisco",
//                    "15,27,109.1,Oakland",
//                    "10,13,108.1,Oakland",
//                    "11,26,107.1,Oakland",
//                    "11,26,107.1,Oakland",
//                    "11,26,107.1,Oakland",
//                    "12,9,106.1,Oakland",
//                    "13,1,105.1,Oakland",
//                    "22,17,104.1,Oakland",
//                    "1,2,103.1,Oakland",
//                    "28,24,102.1,Oakland",
//                    "18,14,11.1,San Jose",
//                    "6,25,10.1,Oakland",
//                    "19,15,9.1,San Jose",
//                    "3,19,8.1,San Jose",
//                    "3,11,7.1,Oakland",
//                    "27,12,6.1,Oakland",
//                    "1,3,5.1,Oakland",
//                    "25,4,4.1,San Jose",
//                    "5,6,3.1,San Jose",
//                    "29,22,2.1,San Jose",
//                    "30,23,1.1,San Jose",
//                    "30,24,1.1,San ant"
//            };
//
//
//            List<String> r = reorderListings(inputCsvArray, 12);
//            for (String line : r) {
//                System.out.println(line);
//            }
//        }
//}
