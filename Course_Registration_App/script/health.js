export async function checkBackendHealth() {
  const lastCheck = parseInt(sessionStorage.getItem("backendHealthCheckedAt") || "0", 10);
  const now = Date.now();

  if (now - lastCheck < 10000) {
    return sessionStorage.getItem("backendHealthStatus") === "ok";
  }

  const controller = new AbortController();
  const timeoutId = setTimeout(() => controller.abort(), 5000);

  try {
    const response = await fetch("http://localhost:8080/health", {
      signal: controller.signal,
    });

    clearTimeout(timeoutId);

    if (response.ok) {
      sessionStorage.setItem("backendHealthStatus", "ok");
      sessionStorage.setItem("backendHealthCheckedAt", now.toString());
      return true;
    }
  } catch (err) {
    console.error("Health Check Failed:", err.name === 'AbortError' ? 'Request timed out' : err);
  }

  sessionStorage.setItem("backendHealthStatus", "fail");
  sessionStorage.setItem("backendHealthCheckedAt", now.toString());
  return false;
}

// 👇 Auto-run when imported
checkBackendHealth();
