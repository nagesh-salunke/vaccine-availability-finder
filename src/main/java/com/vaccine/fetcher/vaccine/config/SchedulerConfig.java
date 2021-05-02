package com.vaccine.fetcher.vaccine.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {

  private static final int DEFAULT_POOL_SIZE = 2;

  @Override
  public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
    ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
    threadPoolTaskScheduler.setPoolSize(DEFAULT_POOL_SIZE);
    threadPoolTaskScheduler.setThreadNamePrefix("ScheduleTaskPool-");
    threadPoolTaskScheduler.initialize();
    scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
  }
}