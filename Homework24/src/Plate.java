public class Plate {
    private int foodAmount;

    public Plate(int startFood) {
        if (startFood < 0) {
            this.foodAmount = 0;
        } else {
            this.foodAmount = startFood;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            this.foodAmount += amount;
            System.out.println("В тарелку добавили " + amount + " еды. Теперь там: " + foodAmount);
        }
    }

    public void decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
        }
    }

    // Метод для подсчета количества еды
    public int getFoodAmount() {
        return foodAmount;
    }
}