//problem1
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n=s.length();
        HashSet<String>set=new HashSet<>();
        HashSet<String> res=new HashSet<>();
        for(int i=0;i<n-9;i++){
            String sp=s.substring(i,i+10);
            if(set.contains(sp)){
                res.add(sp);
            }else{
                set.add(sp);
            }
        }
        return new ArrayList<>(res);
    }
}
//problem2
public class Main {

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        
        HashMap<String, String> songToGenreMap = new HashMap<>();
        
        for(String genre : genreMap.keySet()){
            List<String> songs = genreMap.get(genre);
            for(String song : songs){
                songToGenreMap.put(song, genre);
            }
        }
        
        HashMap<String, List<String>> result = new HashMap<>();
        
        for(String user : userMap.keySet()){
            result.put(user, new ArrayList<>());
            List<String> songs = userMap.get(user);
            HashMap<String, Integer> frqMap = new HashMap<>();
            int max = 0;
            
            for(String song : songs){
                String genre = songToGenreMap.get(song);
                frqMap.put(genre, frqMap.getOrDefault(genre, 0)+1);
                
                if(max < frqMap.get(genre)){
                    result.get(user).clear();
                    result.get(user).add(genre);
                }else if(max == frqMap.get(genre)){
                     result.get(user).add(genre);
                }
                max = Math.max(max, frqMap.get(genre));
            }
        }
        
        return result;
    }

    public static void main(String[] args) {

        HashMap<String, List<String>> userSongs = new HashMap<>();

        userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));
        userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

        HashMap<String, List<String>> songGenres = new HashMap<>();

        songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"})); 
        songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"})); 
        songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"})); 
        songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"})); 
        songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"})); 

        Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

        System.out.println(res);
    }
}
