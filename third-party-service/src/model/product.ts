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
    const minCode: number = 1000;
    const maxCode: number = 9999;
    let codeId: string = 'PC-';

    const numberCode: number = Math.floor(Math.random() * (maxCode - minCode + 1) + minCode);

    return codeId + numberCode;
  }

  private generateName(): string {
    const name = 'Product Name ';

    const characters: string = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    const rangeName: number = 5;
    let randomName: string = '';

    for (let i = 0; i <= rangeName; i++) {
      randomName += characters.charAt(Math.floor(Math.random() * characters.length));
    }

    return name + randomName;
  }
  
}