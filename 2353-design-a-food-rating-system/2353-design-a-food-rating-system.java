class FoodRatings {
    
    HashMap<String, PriorityQueue<Food>> x = new HashMap<>(); // get pq from cuisine name
    HashMap<String, Food> menu = new HashMap<>(); // get Food (object) by food name

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i=0; i<foods.length; i++){
            if(!x.containsKey(cuisines[i])){
                PriorityQueue<Food> pq = new PriorityQueue<>((a,b)->
                b.rating-a.rating==0 ? a.name.compareTo(b.name) : b.rating-a.rating);
                x.put(cuisines[i], pq);
            }

            Food curr = new Food(foods[i], cuisines[i], ratings[i]);
            PriorityQueue<Food> pq = x.get(cuisines[i]);
            pq.add(curr);
            menu.put(foods[i], curr);
        }
    }

    public void changeRating(String food, int newRating) {
        Food curr = menu.get(food);
        PriorityQueue<Food> pq = x.get(curr.cuisine);
        pq.remove(curr);
        curr.rating = newRating;
        pq.add(curr);
    }

    public String highestRated(String cuisine) {
        return x.get(cuisine).peek().name;
    }

    class Food{
        int rating;
        String name, cuisine;
        Food(String name, String cuisine, int rating){
            this.name = name; this.rating = rating; this.cuisine = cuisine;
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 
 
 dosa -> south : 3
 samosa -> street : 4
 naan -> north  : 5
 paneer -> north : 6
 
 map => cuisine : priorityQueue<food, rating> based on rating
 north -> naan:5 ; paneer:6
 
 changeRating(samosa, 5)
 highestRating(north) -> using pq
 
 ------------------------------
 "kimchi", "miso","    sushi",   "moussaka","ramen","   bulgogi"
 "korean", "japanese","japanese","greek","   japanese","korean"
  9,        12,        8->16        15,       14->16,        7
 
 
 ["korean"],["japanese"],["sushi",16],["japanese"],["ramen",16],["japanese"]
 */