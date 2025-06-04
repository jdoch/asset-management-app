import {AddressDto} from "./address-dto";

export interface CompanyDetailsDto {
  id: string;
  name: string;
  address: AddressDto | null;
}
