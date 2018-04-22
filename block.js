class Block {
    constructor(index, previousHash, timestamp, blockData, hash) {
        this.index = index;
        this.previousHash = previousHash.toString();
        this.timestamp = timestamp;
        this.data = blockData.data;
        this.riskFactor = blockData.riskFactor;
        this.pos = blockData.pos;
        this.animalType = blockData.animalType;
        this.animalName = blockData.animalName;
        this.hash = hash.toString();
    }
}

// var getGenesisBlock = () => {
//     return new Block(0, "0", 1465154705, { qrCode: '123ABC', animalType: 'mammal', animalName: 'Lion'}, "816534932c2b7154836da6afc367695e6337db8a921823784c14378abed4f7d7");
// };

module.exports = { Block }
