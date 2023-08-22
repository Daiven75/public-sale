export class Product {

  private readonly code: string;
  private readonly name: string;

  constructor() {
    this.code = this.generateCode();
    this.name = this.generateName();
  }

  getCode(): string {
    return this.code;
  }

  getName(): string {
    return this.name;
  }

  private generateCode(): string {
    const characters: string = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
    const rangeCode: number = 4;
    let result: string = '';

    for (let i = 0; i <= rangeCode; i++) {
      result += characters.charAt(Math.floor(Math.random() * rangeCode));
    }

    return result;
  }

  private generateName(): string {
    const name = 'Product Name ';
    const rangeNameId: number = 50;
    const randomId: number = Math.floor(Math.random() * rangeNameId);
    return name + randomId;
  }
}