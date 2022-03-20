package by.prohor.booklib.external.alfabank.model;


import java.math.BigDecimal;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;



@ApiModel(description = "Выходная модель, содержащая основные курсы валют Альфа-Банка")
@Validated
public class RateListResponse   {
    @JsonProperty("rates")
    @Valid
    private List<Rate> rates = null;

    public RateListResponse rates(List<Rate> rates) {
        this.rates = rates;
        return this;
    }

    public RateListResponse addRatesItem(Rate ratesItem) {
        if (this.rates == null) {
            this.rates = new ArrayList<Rate>();
        }
        this.rates.add(ratesItem);
        return this;
    }
    @ApiModelProperty(value = "Список основных курсов валют Альфа-Банка")

    @Valid

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RateListResponse rateListResponse = (RateListResponse) o;
        return Objects.equals(this.rates, rateListResponse.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rates);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("class RateListResponse {\n");
        stringBuilder.append("    rates: ").append(toIndentedString(rates)).append("\n");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }


    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
    public Map<String, BigDecimal> toCurrency(BigDecimal price) {
        Map<String, BigDecimal> prices = new HashMap<>();

        for(Rate rate : rates) {
            if (rate.getName()!=null) {
                Double quantity = rate.getQuantity()*Double.valueOf(String.valueOf(price));
                prices.put(rate.getSellIso(), BigDecimal.valueOf(quantity));
            }
        }
        return prices;
    }
}

