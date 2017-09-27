package com.plugin.awesomejava.Location;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.plugin.awesomejava.Forecast.FeedEntry;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class GetCurrentRegion {

    private static final String dbLocation = "/GeoLiteCity.dat";
    private final File database;

    public GetCurrentRegion() {
        this.database = getResourceAsFile(dbLocation);

    }

    public FeedEntry GetLocationServices() {

        FeedEntry entry = null;
        try {

            if (this.database == null) {
                return entry;
            }

            LookupService lookup = new LookupService(this.database, LookupService.GEOIP_MEMORY_CACHE);
            Location locationServices = lookup.getLocation(LocationInfo.getIp());

             if (locationServices == null) {
                return entry;
            }
            String City = locationServices.city;
            String CountryCode = locationServices.countryCode;

            entry = new FeedEntry();
            entry.setLocation(City);
            entry.setCountryCode(CountryCode);
            entry.setDays(7);

        } catch (Exception ex) {
            ex.printStackTrace();
            return entry;
        }
        return entry;
    }

    private File getResourceAsFile(String resourcePath) {
        try {
            InputStream in = getClass().getResourceAsStream(resourcePath);
            if (in == null) {
                return null;
            }

            File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".tmp");
            tempFile.deleteOnExit();

            try (FileOutputStream out = new FileOutputStream(tempFile)) {
                byte[] buffer = new byte[2048];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
}
