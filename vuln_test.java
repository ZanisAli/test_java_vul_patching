public class VulnerableFunctions {

    public Executor taskExecutor() {
        return new SyncTaskExecutor();
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


    public void restartService(String serviceName) {
        if (serviceName != null && !serviceName.isEmpty()) {
            String command = "systemctl restart " + serviceName;
            Runtime.getRuntime().exec(command);
        }
    }


    public void readFile(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            String filePath = "/var/www/files/" + fileName;
            File file = new File(filePath);
            // Read file content (omitted for brevity)
        }
    }


    public void deserializeObject(byte[] data) {
        if (data != null && data.length > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
                Object obj = ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
