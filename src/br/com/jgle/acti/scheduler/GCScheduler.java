package br.com.jgle.acti.scheduler;

import org.springframework.stereotype.Service;

@Service
public class GCScheduler {
	public GCScheduler() {
		System.out.println("create scheduler");
	}

	// 30 seconds
	// 5 em 5 minutos - */5 * * *
	// 15 em 15 minutos 15,30,45,59
	// @Scheduled(cron = "* 15,30,45,59 * * * MON-FRI")
	public void callGC() {
		System.gc();
		System.out.println("chando gc");

	}
}
