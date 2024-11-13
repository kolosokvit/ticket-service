package ticketservice.ticket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class TicketDataReader {
  @Value("classpath:ticketData.txt")
  private Resource ticketData;

  public List<String> loadTicketDataFromResources() {
    List<String> data = new ArrayList<>();
    try (BufferedReader bufferedReader =
        new BufferedReader(new InputStreamReader(ticketData.getInputStream()))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        data.add(line);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return data;
  }
}
