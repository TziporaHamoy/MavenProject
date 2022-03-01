public class CoinFactory {
    public static Coin getCoinInstance(Coins Coin) {

        switch (Coin) {
            case ILS:
                return new ILS();
            case  USD:
                return new USD();
        }
        return null;
    }
}