package asynchronous;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class GenerateStatisticsAccountsTask implements Callable<Integer> {

    public static final int ERROR_PROCESSING_FILE = 0;
    public static final int SUCCESS = 1;

    @Override
    public Integer call() throws Exception {
        System.out.println("Generate statistics of accounts");

        TimeUnit.SECONDS.sleep(6);

        String inputFilePath = "src/resources/bank_balances.csv";
        String outputFilePath = "src/resources/only_balances.csv";

        return cleanWrongData(inputFilePath, outputFilePath);
    }

    private int cleanWrongData(String inputFilePath, String outputFilePath) {
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
                String balance = accountDetails[1];

                if(balance.matches(".*\\d.*")){
                    // Write to the output CSV
                    writer.append(accountNumber).append(",").append(balance).append("\n");
                }
                else{
                    System.out.println("El valor del campo balance no son numeros: " + balance);
                }

            }

        } catch (IOException e) {
            System.out.println(e.toString());
            return ERROR_PROCESSING_FILE;

        }
        return SUCCESS;
    }
}

