package asynchronous;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class LongProcessingTaskFuture implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {

        System.out.println("Init processing of accounts: ");

        String inputFilePath = "src/resources/bank_accounts.csv";
        String outputFilePath = "src/resources/bank_balances.csv";
        processCSV(inputFilePath, outputFilePath);

        TimeUnit.SECONDS.sleep(4);
        return 1;
    }

    public int processCSV(String inputFilePath, String outputFilePath) {
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             FileWriter writer = new FileWriter(outputFilePath)) {

            // Write header for the output CSV
            writer.append("Account Number,Balance\n");

            // Skip the header of the input CSV
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] accountDetails = line.split(csvSplitBy);

                // Extract Account Number and Balance
                String accountNumber = accountDetails[0];
                String balance = accountDetails[4];

                // Write to the output CSV
                writer.append(accountNumber).append(",").append(balance).append("\n");
            }

        } catch (IOException e) {
            System.out.println(e.toString());
            return 0;

        }
        return 1;
    }
}

