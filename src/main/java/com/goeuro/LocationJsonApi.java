package com.goeuro;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Created by Anshul on 06/12/15.
 */
public class LocationJsonApi {
        private static Logger LOG = LoggerFactory.getLogger(LocationJsonApi.class);
        private static String API_ENDPOINT = "http://api.goeuro.com/api/v2/position/suggest/en/";
        private static String CSV_EXTENSION = ".csv";

        public static void main(String[] args) {
                LocationJsonApi jsonApi = new LocationJsonApi();
                if (args.length == 0) {
                        LOG.info("No argument found. Please input city name");
                        System.exit(-1);
                }
                if (args.length > 1) {
                        LOG.info("More than one string is given as input. Please enter only one input");
                        System.exit(-1);
                }
                String inputCityName = args[0];
                List<City> cities = jsonApi.getListOfCities(API_ENDPOINT, args[0]);
                jsonApi.populateCSVFile(cities, inputCityName.concat(CSV_EXTENSION));

        }




        private List<City> getListOfCities(String endpoint, String city) {
                City[] arrayOfCities = null;
                String rawOutput = null;
                try {
                        String endUrl = new StringBuilder().append(endpoint).append(city).toString();
                        LOG.info("API end point {}", endUrl);
                        Client client = Client.create();

                        WebResource webResource = client
                                .resource(endUrl);

                        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON)
                                .get(ClientResponse.class);

                        if (response.getStatus() != 200) {
                                throw new RuntimeException("Failed : HTTP error code : "
                                        + response.getStatus());
                        }
                        rawOutput = response.getEntity(String.class);
                        LOG.trace("raw response {}", rawOutput);
                } catch (Exception e) {
                        LOG.error(e.getMessage(), e);
                }
                if (StringUtils.isEmpty(rawOutput)) {
                        LOG.info("No response found, Returning");
                        return null;
                }
                try {
                        ObjectMapper mapper = new ObjectMapper();
                        arrayOfCities = mapper.readValue(rawOutput, City[].class);
                        LOG.info("Successfully mapped json to POJO");
                } catch (JsonGenerationException e) {
                        LOG.error(e.getMessage(), e);
                } catch (JsonMappingException e) {
                        LOG.error(e.getMessage(), e);
                } catch (Exception e) {
                        LOG.error(e.getMessage(), e);
                }

                return Arrays.asList(arrayOfCities);
        }




        private void populateCSVFile(List<City> listOfCities, String fileName) {
                LOG.info("Writing into file {}", fileName);
                CsvMapper mapper = new CsvMapper();
                CsvSchema schema = mapper.schemaFor(City.class).withHeader();
                ObjectWriter writer = mapper.writer(schema.withLineSeparator("\n"));
                try {
                        writer.writeValue(new FileOutputStream((fileName)), listOfCities);
                        LOG.info("CSV File successfully created. Done!");
                } catch (Exception e) {
                        LOG.error("Error writing to csv file ", e);
                }
        }
}
