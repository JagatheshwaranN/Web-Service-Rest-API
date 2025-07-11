const BACKEND_HEALTH_KEY = "backendHealthStatus";
const HEALTH_CHECK_TIMESTAMP = "backendHealthCheckedAt";
const HEALTH_TIMEOUT = 10000;

export async function checkBackendHealth() {
  const lastCheck = parseInt(
    sessionStorage.getItem(HEALTH_CHECK_TIMESTAMP) || "0",
    10
  );
  const now = Date.now();

  if (now - lastCheck < HEALTH_TIMEOUT) {
    return sessionStorage.getItem(BACKEND_HEALTH_KEY) === "ok";
  }

  const controller = new AbortController();
  const timeoutId = setTimeout(() => controller.abort(), 5000); // 5 sec timeout

  try {
    const response = await fetch("http://localhost:8080/health", {
      signal: controller.signal,
    });

    clearTimeout(timeoutId);

    if (response.ok) {
      sessionStorage.setItem(BACKEND_HEALTH_KEY, "ok");
      sessionStorage.setItem(HEALTH_CHECK_TIMESTAMP, now.toString());
      return true;
    }
  } catch (err) {
    console.error("Health Check Failed:", err.name === 'AbortError' ? 'Request timed out' : err);
  }

  sessionStorage.setItem(BACKEND_HEALTH_KEY, "fail");
  sessionStorage.setItem(HEALTH_CHECK_TIMESTAMP, now.toString());
  return false;
}
