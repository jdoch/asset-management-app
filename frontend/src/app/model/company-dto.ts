import {AddressDto} from "./address-dto";

export interface CompanyDto {
  name: string,
  address: AddressDto | undefined
}
