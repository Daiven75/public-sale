import { Injectable, Logger } from '@nestjs/common';
import { Proposal } from './model/proposal';

@Injectable()
export class SchedulerService {

  private readonly logger = new Logger(SchedulerService.name);

  generateData(): Proposal[] {
    const amountOfProposals: number = this.amount();
    let proposals: Proposal[] = [];
    for(let i = 0; i < amountOfProposals; i++) {
      proposals.push(new Proposal());
    }
    return proposals;
  }

  private amount(): number {
    const max: number = 2000;
    const min: number = 50;
    return Math.random() * (max - min) + min;
  }
}
