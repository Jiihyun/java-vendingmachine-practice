package vendingmachine.domain.dto.output;

public record CoinQuantitiesResponse(int quantityOf500, int quantityOf100, int quantityOf50, int quantityOf10) {
}
