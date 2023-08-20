import { Module } from '@nestjs/common';
import { SchedulerService } from './scheduler.service';
import { ScheduleModule } from '@nestjs/schedule';
import { AppController } from './app.controller';

@Module({
  imports: [ScheduleModule.forRoot()],
  controllers: [AppController],
  providers: [SchedulerService],
})
export class AppModule {}
