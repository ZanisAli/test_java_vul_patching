public class VulnerableFunctions {

    //A function that constructs SQL queries by concatenating user input without proper sanitization.
    public void getUserData(String username) {
    String query = "SELECT * FROM users WHERE username = '" + username + "';";
    // Execute the query (vulnerable to SQL injection)
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    }

    // A function that executes OS commands using user input without proper validation.
    public void pingHost(String host) throws IOException {
    Runtime.getRuntime().exec("ping -c 4 " + host);
    }

    // A function that accesses files using user input without proper validation.
    public String readFile(String filename) throws IOException {
    String path = "/var/www/html/" + filename;
    return new String(Files.readAllBytes(Paths.get(path)));
   }

    //  A function that copies data into a fixed-size buffer without checking the length of the input.
    public void copyString(String input) {
    byte[] buffer = new byte[64];
    System.arraycopy(input.getBytes(), 0, buffer, 0, input.length());
    }

    // use of hard coded credentials
    public void connectToDatabase() {
    String username = "admin";
    String password = "password123";
    // Use credentials to connect to the database
    }

    public void destroy() {
        if (null != redisContainer && redisContainer.isRunning()) {
            redisContainer.close();
        }
    }


    public void deleteUser(String userId) {
        if (userId != null && !userId.isEmpty()) {
            String query = "DELETE FROM users WHERE id = '" + userId + "';";
            database.execute(query);
        }
    }


    public void readFile(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            String filePath = "/var/www/files/" + fileName;
            File file = new File(filePath);
            // Read file content (omitted for brevity)
        }
    }


}
