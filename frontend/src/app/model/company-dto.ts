import {AddressDto} from "./address-dto";

export interface CompanyDto {
  name: string,
  addressDto: AddressDto | undefined
}
