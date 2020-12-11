public class IngredientSortOutException extends RuntimeException
{
    public IngredientSortOutException(Drinks theDrink)
    {
        if (theDrink instanceof Beers)
        {
            System.out.println("Error: the Beer " + theDrink.getName() + " Sold Out.");
        } else if (theDrink instanceof Juice)
        {
            System.out.println("Error: the Juice " + theDrink.getName() + " Sold Out.");
        }
    }
}
