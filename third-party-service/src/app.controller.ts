import { Controller, Get } from "@nestjs/common";
import { SchedulerService } from "./scheduler.service";
import { Proposal } from "./model/proposal";

@Controller()
export class AppController {

    constructor(private readonly schedulerService: SchedulerService) {}

    @Get()
    findAllData(): Proposal[] {
        const hasData: boolean = Math.random() >= 0.5;
        return hasData ? this.schedulerService.generateData() : [];
    }

}