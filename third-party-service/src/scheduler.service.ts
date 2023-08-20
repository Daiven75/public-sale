import { Injectable, Logger } from '@nestjs/common';
import { Proposal } from './model/proposal';
import { Product } from './model/product';
import { Author } from './model/autor';

@Injectable()
export class SchedulerService {

  private readonly logger = new Logger(SchedulerService.name);

  generateData(): Proposal[] {
    const amountOfProposals: number = this.amount();
    let proposals: Proposal[] = [];
    const p: Proposal = new Proposal();
    for(let i = 0; i < amountOfProposals; i++) {
      proposals.push(new Proposal());
    }
    return proposals;
  }

  private amount(): number {
    const max: number = 6;
    const min: number = 2;
    return Math.random() * (max - min) + min;
  }
}
