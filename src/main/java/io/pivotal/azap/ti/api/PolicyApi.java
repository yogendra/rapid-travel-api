package io.pivotal.azap.ti.api;

import io.pivotal.azap.ti.db.DailyPolicyRepository;
import io.pivotal.azap.ti.db.HourlyPolicyRepository;
import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/policies")
public class PolicyApi {

  private DailyPolicyRepository dailyPolicyRepository;
  private HourlyPolicyRepository hourlyPolicyRepository;

  @Autowired
  public PolicyApi(DailyPolicyRepository dailyPolicyRepository,
      HourlyPolicyRepository hourlyPolicyRepository) {
    this.dailyPolicyRepository = dailyPolicyRepository;
    this.hourlyPolicyRepository = hourlyPolicyRepository;
  }

  @GetMapping("/{id}")
  public Policy get(@PathVariable("id") Long id){
    return Policy.builder().id(id).build();
  }

  @GetMapping("/")
  public List<Policy> getAll(){
    return Arrays.asList(
        Policy.builder()
            .id(1l)
            .coverage(new Amount(Currency.getInstance("USD"), 10.00f))
            .name("Weekly Ski Insurance")
            .build(),

        Policy.builder()
            .id(2l)
            .name("Hourly Ski Insurance")
            .coverage(new Amount(Currency.getInstance("USD"), 2.00f))
            .build()

    );
  }

  @PostMapping("/")
  public Policy buy(Policy policy){
    return null;
  }

}
